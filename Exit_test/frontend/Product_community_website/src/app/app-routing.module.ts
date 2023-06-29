import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
  {path:'', redirectTo:'homeng-page', pathMatch:'full'},
  {path:'login', component:LoginComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'home-page',component:HomePageComponent},
  {path:'admin-dashboard',component:AdminDashboardComponent},
  {path:'user-dashboard',component:UserDashboardComponent},
  {path:'search-product',component:SearchProductComponent},
  {path:'all-products',component:AllProductsComponent},
  {path:'product-details',component:ProductDetailsComponent},
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
