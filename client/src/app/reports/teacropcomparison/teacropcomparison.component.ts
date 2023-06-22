import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {ArrearsByProgram} from "../../entity/report/arrearsbyprogram";
import {Teacrop} from "../../entity/report/teacrop";

declare var google: any;

@Component({
  selector: 'app-tea-crop-comparison',
  templateUrl: './teacropcomparison.component.html',
  styleUrls: ['./teacropcomparison.component.css']
})
export class TeacropcomparisonComponent implements OnInit {

  teacrops!:Teacrop[];
  teacropup: Array<Teacrop>= [];
  teacropdown: Array<Teacrop>= [];
  data!:MatTableDataSource<Teacrop>;

  columns: string[] = ['areacode','date','quantity1','quantity2','productionstate','difference','percentage'];
  headers: string[] = ['AreaCode','Date','LastQuantity','CurrentQuantity','Productivity','Difference','Percentage'];
  binders: string[] = ['area','date','lastmonthquantity','currentmonthquantity','productionstate','difference','percentage'];

  @ViewChild('columnchart', {static: false}) columnchart: any;
  @ViewChild('piechartup', { static: false }) piechartup: any;
  @ViewChild('piechartdown', { static: false }) piechartdown: any;

  constructor() {

  }

  ngOnInit(): void {

    let area1: Teacrop = new Teacrop("A-001", "2023-01-12", 'up',320, 350,30, 9.37);
    let area2: Teacrop = new Teacrop("A-002", "2023-01-12", 'down',220, 200,20, 9.09);
    let area3: Teacrop = new Teacrop("A-003", "2023-01-12", 'down',150, 140,10, 6.66);
    let area4: Teacrop = new Teacrop("B-001", "2023-03-30", 'up',180, 198,18, 10);
    let area5: Teacrop = new Teacrop("B-002", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area6: Teacrop = new Teacrop("B-003", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area7: Teacrop = new Teacrop("B-004", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area8: Teacrop = new Teacrop("C-002", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area9: Teacrop = new Teacrop("C-003", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area10: Teacrop = new Teacrop("C-001", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area11: Teacrop = new Teacrop("D-003", "2023-03-30",'down', 210, 200,10, 4.76);
    // let area12: Teacrop = new Teacrop("D-002", "2023-03-30",'down', 210, 200,10, 4.76);

    this.teacrops = [area1,area2,area3,area4,area5];

    this.loadTable();
    this.loadCharts();

  }

  loadTable(): void {
    this.data = new MatTableDataSource(this.teacrops);
  }

  loadCharts(): void {
    google.charts.load('current', {packages: ['corechart']});
    google.charts.setOnLoadCallback(this.drawCharts.bind(this));
  }


  drawCharts() {
    const barData = new google.visualization.DataTable();
    barData.addColumn('string', 'areaCode');
    barData.addColumn('number', 'lastmonthquantity');
    barData.addColumn('number', 'currentmonthquantity');
    // barData.addColumn('number', 'percentage');

    const pieDataUp = new google.visualization.DataTable();
    pieDataUp.addColumn('string', 'areacode');
    pieDataUp.addColumn('number', 'percentage');

    const pieDataDown = new google.visualization.DataTable();
    pieDataDown.addColumn('string', 'areacode');
    pieDataDown.addColumn('number', 'percentage');


    this.teacrops.forEach((teacrop: Teacrop) => {

      if(teacrop.productionstate==='up') {
        this.teacropup.push(teacrop);

      }
      else {
        this.teacropdown.push(teacrop);
      }

      barData.addRow([teacrop.area, teacrop.lastmonthquantity, teacrop.currentmonthquantity]);
    });

    this.teacropup.forEach( (teacropup: Teacrop) => {
      pieDataUp.addRow([teacropup.area,teacropup.percentage]);
    });

    this.teacropdown.forEach( (teacropdown: Teacrop) => {
      pieDataDown.addRow([teacropdown.area,teacropdown.percentage]);
    });

    const barOptions = {
      title: 'Tea Crop Summary (Bar Chart)',
      // subtitle: 'Count of Employees by Designation',
      bars: 'vertical',
      height: 400,
      width: 800,
    };

    const pieOptions = {
      title: 'Tea Crop Summary (Pie Chart)',
      height: 400,
      width: 550,
    };

    const columnChart = new google.visualization.ColumnChart(this.columnchart.nativeElement);
    columnChart.draw(barData, barOptions);

    const pieChartUp = new google.visualization.PieChart(this.piechartup.nativeElement);
    pieChartUp.draw(pieDataUp, pieOptions);

    const pieChartDown = new google.visualization.PieChart(this.piechartdown.nativeElement);
    pieChartDown.draw(pieDataDown, pieOptions);



    }


  }


