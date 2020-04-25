import {Component, OnInit} from '@angular/core';
import {Chapter} from './chapter';
import {Story} from './../story/story';
import {ChapterService} from './chapter.service';
import {ActivatedRoute} from '@angular/router';

@Component({
    selector: 'app-chapter',
    templateUrl: './chapter.component.html',
    styleUrls: ['./chapter.component.css']
})
export class ChapterComponent implements OnInit{
    displayChapter: Chapter;
    displayStory: Story;
    topicId: number;
    storyId: number;
    chapterId: number;
    constructor(private _chapterService: ChapterService, private route: ActivatedRoute){
    }

    ngOnInit(): void{
        this.topicId = +this.route.snapshot.params['topidId'];
        this.storyId = +this.route.snapshot.params['storyId'];
        this.getChapter();
    }

    getChapter(): void{
        this._chapterService.getChapter(this.topicId, this.storyId, this.chapterId)
            .subscribe((chapterData) => {this.displayChapter = chapterData, 
                console.log(chapterData)
            }, (error) => {
                console.log(error);
            });
    }
}