import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./view/login/login.component";
import {MainwindowComponent} from "./view/mainwindow/mainwindow.component";
import {EmployeeComponent} from "./view/modules/employee/employee.component";
import {HomeComponent} from "./view/home/home.component";
import {UserComponent} from "./view/modules/user/user.component";
import {AreaComponent} from "./view/modules/area/area.component";
import {CountbydesignationComponent} from "./reports/countbydesignation/countbydesignation.component";
import {CountareabyrootComponent} from "./reports/countareabyroot/countareabyroot.component";
import {ArrearsByProgramComponent} from "./reports/arrearsbyprogram/arrearsbyprogram.component";
import {TeacropcomparisonComponent} from "./reports/teacropcomparison/teacropcomparison.component";
import {PluckingComponent} from "./view/modules/plucking/plucking.component";

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "", redirectTo: 'login', pathMatch: 'full'},
  {
    path: "main",
    component: MainwindowComponent,
    children: [
      {path: "home", component: HomeComponent},
      {path: "employee", component: EmployeeComponent},
      {path: "user", component: UserComponent},
      {path: "area", component: AreaComponent},
      {path: "plucking", component: PluckingComponent},
      {path: "reportcountbydesignation", component: CountbydesignationComponent},
      {path: "reportcountareabyroot", component: CountareabyrootComponent},
      {path: "reportarrearsbyprogram", component: ArrearsByProgramComponent},
      {path: "reportteacrop", component: TeacropcomparisonComponent}
      // {path: "maligathenna", component: MaligathannaComponent}
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
