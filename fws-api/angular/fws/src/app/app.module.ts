import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChapterComponent} from './content/chapter/chapter.component';
import { ChapterService} from './content/chapter/chapter.service';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './core/page-not-found/page-not-found.component';
import { BookShelfComponent } from './content/bookshelf/bookshelf.component';
import { StoryListComponent } from './content/story-list/story-list.component';
import { StoryListService} from './content/story-list/story-list.service';
import { HeaderComponent } from './core/header/header.component';
import { FooterComponent } from './core/footer/footer.component';
import { StoryComponent } from './content/story/story.component';

@NgModule({
  declarations: [
    AppComponent,
    ChapterComponent,
    HomeComponent,
    PageNotFoundComponent,
    BookShelfComponent,
    StoryListComponent,
    HeaderComponent,
    FooterComponent,
    StoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ChapterService, StoryListService],
  bootstrap: [AppComponent]
})
export class AppModule { }
