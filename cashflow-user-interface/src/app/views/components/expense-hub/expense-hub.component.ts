import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Expense } from '../../interface/Expense.interface';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatMenuModule } from '@angular/material/menu';

export interface Store {
  id: number;
  city: string;
  banner: string;
  area: string;
  type: string;
  state: string;
  avBasket: string;
}

@Component({
  selector: 'app-expense-hub',
  standalone: true,
  imports: [
    MatIconModule,
    MatCardModule,
    MatTableModule,
    CommonModule,
    MatPaginatorModule,
    MatMenuModule
  ],
  templateUrl: './expense-hub.component.html',
  styleUrl: './expense-hub.component.scss'
})
export class ExpenseHubComponent implements AfterViewInit{

  displayedColumns: string[] = ['id', 'city', 'banner', 'area', 'type', 'state', 'avBasket', 'actions'];
  dataSource = new MatTableDataSource<Store>([
    { id: 7892, city: 'Lyon', banner: 'SUPER', area: 'CENTRE-EST', type: 'Franchisé', state: 'OPEN', avBasket: '31,53' },
    { id: 2304, city: 'Paris', banner: 'HYPER', area: 'NORD', type: 'Franchisé', state: 'CLOSED', avBasket: '0,00' },
    { id: 4543, city: 'La Gorgue', banner: 'SUPER', area: 'REGION PARISIENNE', type: 'Franchisé', state: 'OPEN', avBasket: '27,32' },
    { id: 5432, city: 'Béziers', banner: 'HYPER', area: 'SUD EST', type: 'Franchisé', state: 'OPEN', avBasket: '31,53' },
    { id: 1324, city: 'Toulouse', banner: 'HYPER', area: 'SUD OUEST', type: 'Franchisé', state: 'OPEN', avBasket: '32,12' },
  ]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  performAction(action: string, row: Store) {
    console.log(`${action} clicked for`, row);
  }

  editRow(an:any) {

  }

  viewRow(ab:any) {

  }

  

}
