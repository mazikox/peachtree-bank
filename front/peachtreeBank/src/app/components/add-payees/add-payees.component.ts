import {Component} from '@angular/core';
import {ClientService} from "../../services/client.service";
import {FormControl, NgForm, Validators} from "@angular/forms";
import {MatDialog, MatDialogModule} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {Router} from "@angular/router";
import {takeUntil} from "rxjs";


@Component({
  selector: 'app-add-payees',
  templateUrl: './add-payees.component.html',
  styleUrls: ['./add-payees.component.scss']
})
export class AddPayeesComponent {
  name = new FormControl('', [
    Validators.required
  ]);
  address = new FormControl('', [
    Validators.required
  ]);
  accountNumber = new FormControl('', [
    Validators.required
  ]);

  constructor(private clientService: ClientService, private dialog: MatDialog, private router: Router) {
  }

  addPayee(data: NgForm) {
    console.log(data.value)
    if (data.valid) {
      this.clientService.addPayee(data.value).pipe().subscribe((data) => {
          setTimeout(() => {
            this.router.navigate(['/transactions']);
          }, 500);
        },
        () => {
          this.openDialog();
        });

    } else {
      this.openDialog();
    }
  }

  openDialog() {
    this.dialog.open(DialogContentExampleDialog);
  }
}

@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: 'dialog-content-example-dialog.html',
  standalone: true,
  imports: [MatDialogModule, MatButtonModule],
})

export class DialogContentExampleDialog {
}
