import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StoryComponent} from './story/story.component';
import { StoryListComponent } from './story-list/story-list.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BookShelfComponent } from './bookshelf/bookshelf.component';

const routes: Routes = [
{ path: '' , redirectTo: '/home', pathMatch: 'full'},
{ path: 'home', component: HomeComponent},
{ path: 'bookshelf', component: BookShelfComponent},
{ path: 'bookshelf/:bookshelfId', component: StoryListComponent},
/*{path: 'recommended/', component: RecommendedComponent} <--- Displays the recommended stories for a user*/
{ path: 'stories/:storyId', component: StoryComponent},
/*{path: 'stories/:storyId/:chapterId', component: ChapterComponent} */
{ path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }