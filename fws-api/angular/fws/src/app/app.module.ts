import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChapterComponent} from './chapter/chapter.component';
import { ChapterService} from './chapter/chapter.service';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BookShelfComponent } from './bookshelf/bookshelf.component';
import { StoryListComponent } from './story-list/story-list.component';
import { StoryListService} from './story-list/story-list.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { StoryComponent } from './story/story.component';

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
