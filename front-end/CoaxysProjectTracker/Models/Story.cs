using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Models
{
    public class Story
    {
        [JsonProperty("id")]
        public int ID { get; set; }

        [Required]
        [Display(Name = "Story Name")]
        [JsonProperty("name")]
        public string Name { get; set; }

        [Display(Name = "Story Description")]
        [DataType(DataType.MultilineText)]
        [JsonProperty("description")]
        public string Description { get; set; }

    }
}
