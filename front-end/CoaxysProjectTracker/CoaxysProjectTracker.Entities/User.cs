using Newtonsoft.Json;
using System;

namespace CoaxysProjectTracker.Entities
{
    public class User
    {
        [JsonProperty("idUser")]
        public int ID { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("email")]
        public string Email { get; set; }

        [JsonProperty("role")]
        public string Role { get; set; }
    }
}