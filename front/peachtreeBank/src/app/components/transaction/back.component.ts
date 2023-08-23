import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {ClientService,} from '../../services/client.service';
import {MatSort} from '@angular/material/sort';
import {MatPaginator,} from '@angular/material/paginator';
import {DataProcessor} from "../../services/data-processor";

@Component({
  selector: 'app-back',
  templateUrl: './back.component.html',
  styleUrls: ['./back.component.scss'],
})
export class BackComponent extends DataProcessor implements AfterViewInit {
  displayColumn: string[] = [
    'id',
    'categoryCode',
    'date',
    'amount',
    'currencyCode',
    'originatorAccountNumber',
    'counterpartyAccount',
    'paymentType',
    'status',
    'title',
  ];
  @ViewChild(MatPaginator) override paginator!: MatPaginator

  constructor(clientService: ClientService) {
    super(clientService);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.processTableData(this.paginator, this.sort, this.TRANSACTION);
  }

  applyFilter(event: Event) {
    this.categoryCode = (event.target as HTMLInputElement).value;
    this.destroy.next();
    this.processTableData(this.paginator, this.sort, this.TRANSACTION);
  }

  override applySort(event: Event) {
    super.applySort(event, this.paginator, this.sort);
  }
}