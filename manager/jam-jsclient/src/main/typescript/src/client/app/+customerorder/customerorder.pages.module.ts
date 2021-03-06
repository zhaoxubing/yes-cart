import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { ServicesModule } from '../shared/services/services.module';

import { CustomerOrdersRoutingModule } from './customerorders-routing.module';
import { CustomerOrderComponent, CustomerOrdersComponent, PaymentsComponent } from './components/index';
import { AllCustomerOrdersComponent, AllPaymentsComponent } from './index';

@NgModule({
    imports: [CustomerOrdersRoutingModule, CommonModule, SharedModule, ServicesModule],
    declarations: [
      CustomerOrderComponent, CustomerOrdersComponent, PaymentsComponent,
      AllCustomerOrdersComponent, AllPaymentsComponent
    ],
    exports: [
      CustomerOrderComponent, CustomerOrdersComponent, PaymentsComponent,
      AllCustomerOrdersComponent, AllPaymentsComponent
    ]
})

export class CustomerOrderPagesModule { }
