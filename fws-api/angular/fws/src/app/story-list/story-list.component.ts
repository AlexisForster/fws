import { Component, OnInit } from '@angular/core';
import {Story} from '../story/story';
import {StoryListService} from './story-list.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-story-list',
  templateUrl: './story-list.component.html',
  styleUrls: ['./story-list.component.css']
})
export class StoryListComponent implements OnInit {
  stories: Story;
  bookshelfId: number;

  constructor(private _articleService: StoryListService, private route: ActivatedRoute){
  }

  ngOnInit(): void{
    this.bookshelfId = +this.route.snapshot.params['bookshelfId'];
    this.getStoriesByBookshelf();
}

getStoriesByBookshelf(): void{
  this._articleService.getStoriesByBookshelf(this.bookshelfId)
      .subscribe((articleData) => {this.stories = articleData, 
          console.log(articleData)
      }, (error) => {
          console.log(error);
      });
  }
}