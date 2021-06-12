import {Injectable} from "@angular/core";
import {Model} from "./app.component";
import {Make} from "./app.component";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) {
  }

  getMakes(): Observable<Array<Make>> {
    return this.http.get<Array<Make>>('http://localhost:8080/car-management/makes');
  }

  getModelsById(id: number): Observable<Array<Model>>{
    return this.http.get<Array<Model>>('http://localhost:8080/car-management/makes/'+id);
  }

  getModelById(id: number): Observable<Array<Model>>{
    return this.http.get<Array<Model>>('http://localhost:8080/car-management/models/id/'+id);
  }
}
