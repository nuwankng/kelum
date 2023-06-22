export class Teacrop {

  public area !: string;
  public date !: string;
  public productionstate !: string;
  public lastmonthquantity!: number;
  public currentmonthquantity!: number;
  public difference!:number;
  public percentage !: number;

  constructor(area:string,date:string,variance:string,lastmonthquantity:number,currentmonthquantity:number,difference:number,percentage:number) {

    this.area=area;
    this.date=date;
    this.productionstate=variance;
    this.lastmonthquantity=lastmonthquantity;
    this.currentmonthquantity=currentmonthquantity;
    this.difference=difference;
    this.percentage=percentage;
  }

}
