import {Component, EventEmitter, Output, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "../Vehicle";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatDividerModule} from "@angular/material/divider";
import {MatIconModule} from "@angular/material/icon";

@Component({
  selector: 'app-vehicle-input',
  templateUrl: './vehicle-input.component.html',
  styleUrls: ['./vehicle-input.component.css'],
  standalone: true,
  imports: [
            MatFormFieldModule,
            FormsModule,
            MatInputModule,
            MatButtonModule,
            MatDividerModule,
            MatIconModule
  ]
})
export class VehicleInputComponent {
  @ViewChild("vehicleForm") vehicleForm!: NgForm;

  @Output() newDataEvent = new EventEmitter();

  constructor(private http: HttpClient) {
  }

  onSubmit(): void{
    this.http.post<Vehicle>(
      "http://localhost:8080/vehicles",
      this.vehicleForm.value
    ).subscribe(data => this.newDataEvent.emit(data))
  }
}
