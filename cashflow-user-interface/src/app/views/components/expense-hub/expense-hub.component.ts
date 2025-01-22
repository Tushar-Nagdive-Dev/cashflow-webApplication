import { Component, ViewChild } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTooltipModule } from '@angular/material/tooltip';
import { NgxChartsModule } from '@swimlane/ngx-charts'; // For charts and graphs


export interface TableData {
  id: number;
  name: string;
  size: string;
  modified: Date;
  kind: string;
  status: 'active' | 'archived' | 'deleted';
}

export interface StatsCard {
  title: string;
  value: string | number;
  icon: string;
  trend: number;
  color: string;
}

@Component({
  selector: 'app-expense-hub',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatTooltipModule,
    NgxChartsModule,
    MatCardModule,
    MatButtonModule,
    MatMenuModule
  ],
  templateUrl: './expense-hub.component.html',
  styleUrl: './expense-hub.component.scss'
})
export class ExpenseHubComponent {
  Math = Math;  // This makes Math available in the template

  displayedColumns: string[] = ['name', 'size', 'modified', 'kind', 'status', 'actions'];
  dataSource: MatTableDataSource<TableData>;
  statsCards: StatsCard[] = [
    {
      title: 'Total Files',
      value: '2,845',
      icon: 'folder',
      trend: 12.5,
      color: '#0071e3'
    },
    {
      title: 'Storage Used',
      value: '156.4 GB',
      icon: 'storage',
      trend: -2.3,
      color: '#ac8e68'
    },
    {
      title: 'Active Files',
      value: '1,458',
      icon: 'file_present',
      trend: 5.8,
      color: '#39b54a'
    },
    {
      title: 'Recent Changes',
      value: '245',
      icon: 'update',
      trend: 8.4,
      color: '#bf4800'
    }
  ];

  @ViewChild(MatSort) sort: MatSort|any;
  @ViewChild(MatPaginator) paginator: MatPaginator|any;

  constructor() {
    const data: TableData[] = [
      { id: 1, name: 'Documents', size: '2.1 GB', modified: new Date('2024-01-20'), kind: 'Folder', status: 'active' },
      { id: 2, name: 'Downloads', size: '5.4 GB', modified: new Date('2024-01-21'), kind: 'Folder', status: 'active' },
      { id: 3, name: 'Project.pdf', size: '2.3 MB', modified: new Date('2024-01-22'), kind: 'PDF Document', status: 'archived' },
      { id: 4, name: 'Report.docx', size: '523 KB', modified: new Date('2024-01-22'), kind: 'Word Document', status: 'active' },
      { id: 5, name: 'Presentation.key', size: '15.2 MB', modified: new Date('2024-01-21'), kind: 'Keynote', status: 'deleted' },
    ];
    this.dataSource = new MatTableDataSource(data);
  }

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  getStatusChipClass(status: string): string {
    const statusMap: { [key: string]: string } = {
      active: 'status-active',
      archived: 'status-archived',
      deleted: 'status-deleted'
    };
    return statusMap[status] || '';
  }

}
