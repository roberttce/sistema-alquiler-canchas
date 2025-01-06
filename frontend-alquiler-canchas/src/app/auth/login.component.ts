import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  // Aquí puedes agregar propiedades y métodos para la lógica del login
  username: string = '';
  password: string = '';

  login() {
    // Lógica básica para el login
    console.log('Intentando iniciar sesión con', this.username, this.password);
  }
}