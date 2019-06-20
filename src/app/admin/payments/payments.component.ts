import { Component, OnInit } from '@angular/core';
import { PaymentDTO } from 'src/dto/paymentdto';
import { PaymentService } from 'src/service/payment.service';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit {

  payments: PaymentDTO[];
  paymenttoinsert: PaymentDTO = new PaymentDTO();

  constructor(private service: PaymentService) { }

  ngOnInit() {
    this.getPayments();
  }

  getPayments(){
    this.service.getAll().subscribe(payments => this.payments = payments );
  }

  delete(payment: PaymentDTO) {
    this.service.delete(payment.id).subscribe(() => this.getPayments());
  }

  update(payment: PaymentDTO){
    this.service.update(payment).subscribe(() => this.getPayments());
  }

  insert(payment: PaymentDTO) {
    this.service.insert(payment).subscribe(() => this.getPayments());
  }
  clear(){
    this.paymenttoinsert = new PaymentDTO();
  }
}
