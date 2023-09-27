import { Component } from '@angular/core';
import {Vehicle} from "./Vehicle";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Vehicles';
  vehicles: Vehicle[] = [];


  constructor(private http: HttpClient) {
  }

  ngOnInit(){
    this.http.get<Vehicle[]>('http://localhost:8080/vehicles')
      .subscribe(data => this.vehicles = data);
  }

  appendData(newVehicle: any): void{
    this.vehicles.push(newVehicle);
  }

  removeItem(vehicleId: number):void{
    this.http.delete<Vehicle>("http://localhost:8080/vehicles/" + vehicleId).subscribe(data =>
    this.vehicles = this.vehicles.filter((vehicle: Vehicle) => vehicle.id !== vehicleId)
    )
  }
}
