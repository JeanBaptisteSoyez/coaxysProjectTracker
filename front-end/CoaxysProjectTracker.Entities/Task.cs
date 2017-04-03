using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Entities
{
    public class Task
    {
        [JsonProperty("id")]
        public int TaskId { get; set; }

        [JsonProperty("name")]
        public string EpicName { get; set; }

        [JsonProperty("description")]
        public string Description { get; set; }

        [JsonProperty("parameters")]
        public string EntryParameter { get; set; }

        [JsonProperty("process")]
        public string Process { get; set; }

        [JsonProperty("result")]
        public string Result { get; set; }
    }
}
