import { Component } from '@angular/core';
import { faCar} from "@fortawesome/free-solid-svg-icons";
import {HttpService} from "./http.service";
import {Event} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Car Library';
  faCar = faCar;
  years: Array<number> = [];
  constructor(private httpService: HttpService) {
    this.getMakes();
    this.getModels(1);
    this.getModelById(1);
  }
  makesList: any;
  modelsList: any;
  modelById: any;
  selected: any;
  money: any;
  hide: boolean = false;

  getMakes(){
    this.httpService.getMakes().subscribe(makes => {
      this.makesList = makes;
    });
  }

  getModels(id:number){
    this.httpService.getModelsById(id).subscribe(models => {
      this.modelsList = models;
      console.log(models);
    });
  }

  getModelById(id:number){
    this.httpService.getModelById(id).subscribe(model => {
      this.modelById = model;
      console.log(model);
      this.years = [];
      for (let i = this.modelById.yearFrom; i <= this.modelById.yearTo; i++) {
        this.years.push(i);
      }
      this.selected = this.years[0];

    });
  }

  selectOption(event: any) {
    this.getModels(event.target.value);
    this.getModelById(event.target.value);
    this.hide = false;
  }

  selectModelOption(event: any) {
    this.getModelById(event.target.value);
    this.hide = false;
  }

  getMoney() {
    this.hide = true;
    this.money = (Math.random() * (3000.0 - 1000.0) + 1000.0).toFixed(2) + " zł"
  }

  changeYear() {
    this.hide = false;
  }
}

export interface Make{
  id?: number;
  name?: string;
}
export interface Model{
  id?: number;
  name?: string;
  yearFrom?: number;
  yearTo?: number;
  idMake?: number;
}
