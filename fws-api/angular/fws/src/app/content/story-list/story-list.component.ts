import { Component, OnInit } from '@angular/core';
import {Story} from '../story/story';
import {StoryListService} from './story-list.service';
import {ActivatedRoute} from '@angular/router';
import { Bookshelf } from '../bookshelf/bookshelf';

@Component({
  selector: 'app-story-list',
  templateUrl: './story-list.component.html',
  styleUrls: ['./story-list.component.css']
})
export class StoryListComponent implements OnInit {
  stories: Story;
  bookshelf: Bookshelf;
  bookshelfId: number;

  constructor(private _storyListService: StoryListService, private route: ActivatedRoute){
  }

  ngOnInit(): void{
    this.bookshelfId = +this.route.snapshot.params['bookshelfId'];
    this.getBookshelf();
    this.getStoriesByBookshelf();
}

getBookshelf(): void{
  this._storyListService.getBookshelf(this.bookshelfId)
      .subscribe((bookshelf) => {this.bookshelf = bookshelf, 
          console.log(bookshelf)
      }, (error) => {
          console.log(error);
      });
  }

getStoriesByBookshelf(): void{
  this._storyListService.getStoriesByBookshelf(this.bookshelfId)
      .subscribe((storyList) => {this.stories = storyList, 
          console.log(storyList)
      }, (error) => {
          console.log(error);
      });
  }


}