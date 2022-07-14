import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from "../shared/shared.module";
import { ServiceModule } from "../service/service.module";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedModule,
    ServiceModule
  ]
})
export class CoreModule { }
