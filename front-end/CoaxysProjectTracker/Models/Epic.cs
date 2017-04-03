using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Models
{
    public class Epic
    {
        [JsonProperty("id")]
        public int ID { get; set; }

        [Required]
        [Display(Name = "Epic Name")]
        [JsonProperty("name")]
        public string Name { get; set; }

        [Display(Name = "Epic Description")]
        [DataType(DataType.MultilineText)]
        [JsonProperty("description")]
        public string Description { get; set; }

        public DateTime CreatedOn { get; set; }

        public List<Story> ListStory { get; set; }

        //[Required]
        public Project Project { get; set; }
    }
}
