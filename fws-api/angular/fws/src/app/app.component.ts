import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'melma-w-routingv2';

  routes = [
    {linkName: 'Home', url: 'home'},
    {linkName: 'Bookshelf', url: 'bookshelf'}
  ]

}
