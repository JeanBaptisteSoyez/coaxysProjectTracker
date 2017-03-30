using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PoC_MvcFromJsonApi.Models
{
    public class User
    {
        /*public User()
        {

        }

        public User(string Json)
        {
            JObject jObject = JObject.Parse(Json);
            JToken jUser = jObject["user"];
            ID = (int)jUser["ID"];
            Name = (string)jUser["Name"];
            //Roles = jUser["Roles"].ToList<string>();
        }*/

        public int? ID { get; set; }
        public string Name { get; set; }
        //public List<string> Roles { get; set; }
    }
}