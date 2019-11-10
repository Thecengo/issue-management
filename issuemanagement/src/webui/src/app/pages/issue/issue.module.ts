import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import {IssueRoutingModule} from "./issue.routing.module";
import { IssueServie } from 'src/app/services/Shared/issue.service';
import { SharedModule } from 'src/shared/shared.module';

@NgModule({
  imports: [
    CommonModule,
    IssueRoutingModule,
    SharedModule
  ],
  providers: [IssueServie],
  declarations: [IssueComponent]
})
export class IssueModule { }
