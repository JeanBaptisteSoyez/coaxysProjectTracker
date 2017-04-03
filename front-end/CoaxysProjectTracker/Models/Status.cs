using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CoaxysProjectTracker.Models
{
    public class Status
    {

        [JsonProperty("id")]
        public int ID { get; set; }

        [Required]
        [JsonProperty("type")]
        public string Type { get; set; }

        [JsonProperty("comment")]
        [DataType(DataType.MultilineText)]
        public string Comment { get; set; }

        [JsonProperty("attachment")]
        public string Attachment { get; set; }

        //[DataType(DataType.Date)]
        //[Display(Name = "Created on")]
        //public DateTime CreatedOn { get; set; }
    }
}