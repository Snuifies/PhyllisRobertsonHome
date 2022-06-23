import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedUiModule } from '../shared-ui/shared-ui.module';

@NgModule({
  imports: [
    CommonModule,
    SharedUiModule
  ],
  exports: [SharedUiModule],
  declarations: []
})
export class SharedModule { }
