import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CountByDesignation} from "../../entity/report/countbydesignation";
import {CountOfAreasByRoot} from "../../entity/report/countofareasbyroot";

@Injectable({
  providedIn: 'root'
})

export class ReportService {

  constructor(private http: HttpClient) {  }

  async countByDesignation(): Promise<Array<CountByDesignation>> {

    const countbydesignations = await this.http.get<Array<CountByDesignation>>('http://localhost:8080/reports/countbydesignation').toPromise();
    if(countbydesignations == undefined){
      return [];
    }
    return countbydesignations;
  }

  async countByArea(): Promise<Array<CountOfAreasByRoot>> {

    const countbyareas = await this.http.get<Array<CountOfAreasByRoot>>('http://localhost:8080/reports/countbyareas').toPromise();
    if(countbyareas == undefined){
      return [];
    }
    return countbyareas;
  }

}
