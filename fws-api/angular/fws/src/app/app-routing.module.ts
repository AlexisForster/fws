import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StoryComponent} from './content/story/story.component';
import { StoryListComponent } from './content/story-list/story-list.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './core/page-not-found/page-not-found.component';
import { BookShelfComponent } from './content/bookshelf/bookshelf.component';

const routes: Routes = [
{ path: '' , redirectTo: '/home', pathMatch: 'full'},
{ path: 'home', component: HomeComponent},
{ path: 'bookshelf', component: BookShelfComponent},
{ path: 'bookshelf/:bookshelfId/stories', component: StoryListComponent},
/*{path: 'recommended/', component: RecommendedComponent} <--- Displays the recommended stories for a user*/
{ path: 'bookshelf/:bookshelfId/stories/:storyId', component: StoryComponent},
/*{path: 'stories/:storyId/:chapterId', component: ChapterComponent} */
{ path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }