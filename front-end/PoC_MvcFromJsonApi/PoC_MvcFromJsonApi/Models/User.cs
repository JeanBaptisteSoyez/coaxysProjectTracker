using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PoC_MvcFromJsonApi.Models
{
    public class User
    {
        public int? ID { get; set; }
        public string Name { get; set; }

        [JsonProperty("userRoles")]
        public List<string> Roles { get; set; }
    }
}