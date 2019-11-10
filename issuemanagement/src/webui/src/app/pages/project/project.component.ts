import { Component, OnInit } from '@angular/core';
import { ProjectService } from 'src/app/services/Shared/project.service';
import { Page } from 'src/app/common/page';
import { Project } from 'src/app/common/project.model';
import { TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  page = new Page();
  cols = [
    {prop: 'id', name: 'No'},
    {prop: 'projectName', name: 'Project Name', sortable: false},
    {prop: 'projectCode', name: 'Project Code', sortable: false}];
  rows = [];

  modalRef: BsModalRef;
  constructor(private projectService: ProjectService,private modalService: BsModalService) { 
    
  }

  ngOnInit() {
  
    this.setPage({ offset: 0 });
  }

  
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.projectService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.number;
      this.page.totalElements=pagedData.totalElements;
      this.rows = pagedData.contents;
    });
  }

}
