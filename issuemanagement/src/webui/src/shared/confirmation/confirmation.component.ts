import { Component, OnInit } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.scss']
})
export class ConfirmationComponent implements OnInit {

  body: string;
  header : string;
  onClose: Subject<boolean>;
  active:boolean;

  constructor(private  bsModelRef: BsModalRef) { }

  ngOnInit() {
    this.onClose = new Subject();
  }

  public showConfirmation(header:string, body: string):void{
    this.header = header;
    this.body = body;
    this.active = true;


  }

  onConfirm(){
    this.active = false;
    this.onClose.next(true);
    this.bsModelRef.hide();

  }
  onCancel(){
    this.active = false;
    this.onClose.next(false);
    this.bsModelRef.hide();

  }

}
