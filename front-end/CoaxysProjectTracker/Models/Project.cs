using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Models
{
    public class Project
    {
        [JsonProperty("idProject")]
        public int ID { get; set; }

        [Required]
        [Display(Name = "Project Name")]
        [JsonProperty("name")]
        public string Name { get; set; }
        
        [DataType(DataType.MultilineText)]
        [Display(Name = "Project Description")]
        [JsonProperty("description")]
        public string Description { get; set; }

        public DateTime CreatedOn { get; set; }
        
        public List<Epic> ListEpic { get; set; }
    }
}
