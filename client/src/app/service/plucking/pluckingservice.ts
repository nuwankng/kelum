import {HttpClient} from "@angular/common/http";
import {Plucking} from "../../entity/plucking/plucking";
import {Injectable} from "@angular/core";
import {Employee} from "../../entity/employee/employee";

@Injectable({
  providedIn: 'root'
})

export class PluckingService {

  constructor(private http: HttpClient) { }

  async getAll(query:string): Promise<Array<Plucking>> {
    const pluckings = await this.http.get<Array<Plucking>>('http://localhost:8080/pluckings'+query).toPromise();
    if(pluckings == undefined){
      return [];
    }
    return pluckings;
  }

  async add(plucking:Plucking): Promise<[]|undefined> {
    console.log("PLO"+plucking);
    // return [];
    return  this.http.post<[]>('http://localhost:8080/pluckings', plucking).toPromise();
  }



}
