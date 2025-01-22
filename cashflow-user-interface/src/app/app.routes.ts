import { Routes } from '@angular/router';
import { WelcomeComponent } from './views/components/welcome/welcome.component';
import { FeaturesViewComponent } from './views/components/features-view/features-view.component';
import { LearnMoreComponent } from './views/components/learn-more/learn-more.component';
import { RegisterComponent } from './views/components/auth/register/register.component';
import { LoginComponent } from './views/components/auth/login/login.component';
import { ExpenseHubComponent } from './views/components/expense-hub/expense-hub.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'welcome',
        pathMatch: 'full'
    },
    {
        path: 'welcome',
        component : WelcomeComponent
    },
    {
        path: 'featureview',
        component: FeaturesViewComponent
    },
    {
        path: 'learn-more',
        component: LearnMoreComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'expenese-hub',
        component: ExpenseHubComponent
    }
];
