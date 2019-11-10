import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectComponent } from './project.component';
import {ProjectRoutingModule} from "./project.routing.module";
import { ProjectService } from 'src/app/services/Shared/project.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { SharedModule } from 'src/shared/shared.module';

@NgModule({
  imports: [
    CommonModule,
    ProjectRoutingModule,
    NgxDatatableModule,
    SharedModule
  ],
  providers: [ProjectService],
  declarations: [ProjectComponent]
})
export class ProjectModule { }
