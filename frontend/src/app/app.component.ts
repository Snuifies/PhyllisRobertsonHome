import { Component, OnInit } from '@angular/core';
import { PrimeNGConfig } from "primeng/api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {

  title = 'frontend';

  constructor(private primengComcfig: PrimeNGConfig) { }

  ngOnInit(): void {
    this.primengComcfig.ripple = true;
  }
}
