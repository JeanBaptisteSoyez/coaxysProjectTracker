using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Models
{
    public class Task
    {
        [JsonProperty("id")]
        public int ID { get; set; }

        [Required]
        [Display(Name = "Task Name")]
        [JsonProperty("name")]
        public string Name { get; set; }

        [Display(Name = "Task Description")]
        [DataType(DataType.MultilineText)]
        [JsonProperty("description")]
        public string Description { get; set; }

        [Display(Name = "Entry Parameters")]
        [DataType(DataType.MultilineText)]
        [JsonProperty("parameters")]
        public string EntryParameter { get; set; }

        [Display(Name = "Process")]
        [DataType(DataType.MultilineText)]
        [JsonProperty("process")]
        public string Process { get; set; }

        [Display(Name = "Result")]
        [DataType(DataType.MultilineText)]
        [JsonProperty("result")]
        public string Result { get; set; }
    }
}
