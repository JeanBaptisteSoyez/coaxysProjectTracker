using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Entities
{
    public class Epic
    {
        [JsonProperty("id")]
        public int EpicId { get; set; }

        [JsonProperty("name")]
        public string EpicName { get; set; }

        [JsonProperty("description")]
        public string Description { get; set; }

        //[JsonProperty("creationdate")]
        //public string CcreatedOn { get; set; }

        //[JsonProperty("childs")]
        //public List<string> Stories { get; set; }

        //[JsonProperty("Parent")]
        //public string Project { get; set; }
    }
}
