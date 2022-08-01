import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { CategoryComponent } from './pages/admin/category/category.component';
import { ProductComponent } from './pages/admin/product/product.component';
import { StockComponent } from './pages/admin/stock/stock.component';
import { MailComponent } from './pages/admin/mail/mail.component';
import { ReportComponent } from './pages/admin/report/report.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { RegisterComponent } from './pages/register/register.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './services/admin.guard';
import {UserGuard} from './services/user.guard';
import { DisplayProductComponent } from './pages/user/display-product/display-product.component';
import { CartComponent } from './pages/user/cart/cart.component';
import { WishlistComponent } from './pages/user/wishlist/wishlist.component';
import { CheckoutComponent } from './pages/user/checkout/checkout.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch: 'full',
  },
  {
    path:'register',
    component:RegisterComponent,
    pathMatch: 'full',
  },
  {
    path:'login',
    component:LoginComponent,
    pathMatch: 'full',
  },
  {
    path:'admin',
    component:DashboardComponent,
    // pathMatch: 'full',
    canActivate: [AdminGuard],
    children:[
      {
        path:'discount',
        component:WelcomeComponent,
      },
      {
        path:'profile',
        component:ProfileComponent,
      },
      {
        path:'category',
        component:CategoryComponent,
      },
      {
        path:'product',
        component:ProductComponent,
      },
      {
        path:'stock',
        component:StockComponent,
      },
      {
        path:'report',
        component:ReportComponent,
      },
      {
        path:'mail',
        component:MailComponent,
      },
    ],
  },
  {
    path:'user-dashboard',
    component:UserDashboardComponent,
    // pathMatch: 'full',
    canActivate: [UserGuard],
    children:[
      {
        path:'',
        component:ProfileComponent,
      },
      {
        path:':catId',
        component:DisplayProductComponent,
      },
      {
        path:'0/cart',
        component:CartComponent,
      },
      {
        path:'0/wishlist',
        component:WishlistComponent,
      },
      {
        path:'0/order',
        component:CheckoutComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
