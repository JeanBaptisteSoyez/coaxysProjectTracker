using Newtonsoft.Json;
using PoC_MvcFromJsonApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace PoC_MvcFromJsonApi.Controllers
{
    public class UserAsyncController : AsyncController
    {
        public void IndexAsync(string city)
        {
            string uri = "http://cpayen.net/api/user.json";
            AsyncManager.OutstandingOperations.Increment();
            using (HttpClient httpClient = new HttpClient())
            {
                Task<String> response = httpClient.GetStringAsync(uri);
                AsyncManager.Parameters["users"] = JsonConvert.DeserializeObject<List<User>>(response.Result);
                AsyncManager.OutstandingOperations.Decrement();
            }
        }
        public ActionResult IndexCompleted(List<User> users)
        {
            return PartialView("_IndexAsync",
                users
            );
        }
    }
}