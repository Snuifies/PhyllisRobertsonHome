import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedUiModule } from "../shared-ui/shared-ui.module";
import { DialogService, DynamicDialogRef, DynamicDialogConfig } from 'primeng/dynamicdialog';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    SharedUiModule
  ],
  exports: [
    FormsModule,
    SharedUiModule
  ],
  providers: [
    DialogService,
    DynamicDialogRef,
    DynamicDialogConfig
  ]
})
export class SharedModule { }
