using CoaxysProjectTracker.Entities;
using Newtonsoft.Json;
using System;
using System.Configuration;
using System.Net.Http;
using System.Threading.Tasks;

namespace CoaxysProjectTracker.Api
{
    public class API
    {
        // Get API conf from main project's Web.config
        private static string BaseUrl = ConfigurationManager.AppSettings.Get("Api.BaseUrl");

        public static async Task<User> LogUserInAsync(string email, string password)
        {
            string uri = BaseUrl;

            if(email == "admin@coaxys.com")
            {
                uri += "login1.json";
            }
            
            if(email == "user@customer.com")
            {
                uri += "login2.json";
            }

            using (HttpClient httpClient = new HttpClient())
            {
                try
                {
                    var response = await httpClient.GetStringAsync(uri);
                    return JsonConvert.DeserializeObject<User>(response);
                }
                catch (Exception)
                {
                    return null;
                }
            }
        }
    }
}
