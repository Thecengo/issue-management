import { Component, OnInit, ViewChild } from '@angular/core';
import { ProjectService } from 'src/app/services/Shared/project.service';
import { Page } from 'src/app/common/page';
import { Project } from 'src/app/common/project.model';
import { TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { ConfirmationComponent } from 'src/shared/confirmation/confirmation.component';
import { UserService } from 'src/app/services/Shared/user.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  @ViewChild('templateProjectDeleteCell') templateProjectDeleteCell : TemplateRef<any>;
  page = new Page();
  cols = [ ];
  rows = [];
  managerOptions = [];

  modalRef: BsModalRef;
  projectForm: FormGroup;

  constructor(private projectService: ProjectService
    , private modalService: BsModalService
    , private formBuilder: FormBuilder
    , private userService: UserService) {

  }

  ngOnInit() {

    this.cols = [
      { prop: 'id', name: 'No' },
      { prop: 'projectName', name: 'Project Name', sortable: false },
      { prop: 'projectCode', name: 'Project Code', sortable: false },
      { prop: 'id', name: 'Action', cellTemplate:this.templateProjectDeleteCell,flexGrow: 1,sortable: false }
    ];

    this.setPage({offset: 0});

    this.projectForm = this.formBuilder.group({
      'projectCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'projectName': [null, [Validators.required, Validators.minLength(4)]],
      'managerId': [null, [Validators.required]]
    });


    this.userService.getAll().subscribe(
      response =>{
          this.managerOptions = response;
          console.log(this.managerOptions);
      });
  }



  get form() {
    return this.projectForm.controls;
  }

  saveProject() {
    if(!this.projectForm.valid)
      return;

    this.projectService.create(this.projectForm.value).subscribe(
      response => {
        console.log(response);
        this.setPage({ offset: 0 });
        this.closeAndResetModal();
      }
    )
 
  }

 closeAndResetModal(){
    this.projectForm.reset();
    this.modalRef.hide();
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.number;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.contents;
    });
  }

  showDeleteConfirmation(){


  }
  showProjectDeleteConfirmation(value){
    const model = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>model.content).showConfirmation(
      "Delete confirmation",
      "Are you sure delete project?"
    );
    (<ConfirmationComponent>model.content).onClose.subscribe(
      result=>{
        if (result === true) {
          this.projectService.delete(value).subscribe(response => {
            if(response===true)
            this.setPage({ offset: 0 });
          });
          
          console.log("yes e tıklandı")

        }else if(result===false){
          console.log("no ya tıklandı")

        }


      });
  }

}
