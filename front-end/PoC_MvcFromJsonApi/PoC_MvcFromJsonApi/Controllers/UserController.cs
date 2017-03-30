using Newtonsoft.Json;
using PoC_MvcFromJsonApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace PoC_MvcFromJsonApi.Controllers
{
    public class UserController : Controller
    {
        // GET: User
        //public ActionResult Index()
        //{
        //Uri apiUrl = new Uri("http://cpayen.net/api/user.json");
        //List<User> Users = new List<User>();

        //List<User> Users = new List<User>();
        /*var syncClient = new WebClient();
        var content = syncClient.DownloadString("http://cpayen.net/api/user.json");
        var userList = JsonConvert.DeserializeObject<List<User>>(content);*/
        /*foreach (string userStr in userList)
        {
            Users.Add(new User(userStr));
        }*/

        /*WebClient wc = new WebClient();
        wc.OpenReadCompleted += (o, a) =>
        {
            var userList = JsonConvert.DeserializeObject<List<string>>(a.Result.ToString());
            foreach (string userStr in userList)
            {
                Users.Add(new User(userStr));
            }
        };
        wc.OpenReadAsync(apiUrl);*/

        //return View(userList);
        //}

        private UserService service = new UserService();

        public async Task<ActionResult> Index()
        {
            return View("index",
                await service.GetUsers()
            );
        }

        public async Task<ActionResult> IndexAsync()
        {
            return PartialView("_IndexAsync",
                await service.GetUsers()
            );
        }
    }

    public class UserService
    {
        readonly string baseUri = "http://cpayen.net/api/user.json";

        public async Task<List<User>> GetUsers()
        {
            string uri = baseUri;
            using (HttpClient httpClient = new HttpClient())
            {
                Task<String> response = httpClient.GetStringAsync(uri);
                return JsonConvert.DeserializeObject<List<User>>(response.Result);
            }
        }
    }
}