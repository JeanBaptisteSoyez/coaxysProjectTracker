//using System;
//using System.Collections.Generic;
//using System.ComponentModel.DataAnnotations;

//namespace ProjectTracker.Models
//{
//    public class Project
//    {
        
//        public int ProjectID { get; set; }

//        [Required]
//        [Display(Name = "Project Title")]
//        public string ProjectName { get; set; }

//        [Required]
//        [Display(Name = "Version")]
//        public string Version { get; set; }

//        public DateTime CreatedOn { get; set; }

//        [DataType(DataType.MultilineText)]
//        [Display(Name = "Description")]
//        public string Description { get; set; }


//        public List<Epic> ListEpic { get; set; }

//    }

//    public class Epic
//    {
//        public int EpicID { get; set; }

//        [Required]
//        [Display(Name = "Epic Title")]
//        public string EpicName { get; set; }

//        [DataType(DataType.MultilineText)]
//        public string Description { get; set; }

//        public DateTime CreatedOn { get; set; }

//        public List<Story> ListStory { get; set; }

//        [Required]
//        public Project Project { get; set; }

//    }

//    public class Story
//    {
//        public int StoryID { get; set; }

//        [Required]
//        [Display(Name = "Story Title")]
//        public string StoryName { get; set; }

//        [DataType(DataType.MultilineText)]
//        public string Description { get; set; }

//        public DateTime CreatedOn { get; set; }

//        public bool isActive = false;
//        public List<Task> ListTask { get; set; }

//        public Epic Epic { get; set; }

//    }

//    public class Task
//        {
//        public int TaskID { get; set; }

//        [Required]
//        [Display(Name = "Task Title")]
//        public string TaskName { get; set; }

//        public DateTime CreatedOn { get; set; }

//        [Display(Name = "Entry Prameters")]
//        [DataType(DataType.MultilineText)]
//        public string EntryParameter { get; set; }

//        [DataType(DataType.MultilineText)]
//        public string Process { get; set; }

//        [DataType(DataType.MultilineText)]
//        public string Result { get; set; }

//        public List<Status> ListStatus { get; set; }
        
//    }

//    public class Status
//    {
//        public int StatusID { get; set; }

//        [Required]
//        public string Label { get; set; }

//        public string Comment { get; set; }

//        public DateTime StatusDate { get; set; }

//        public List<Byte> Attachment { get; set; }


//    }
//}