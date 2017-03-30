using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
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

        public async Task<ActionResult> ComplexIndexAsync()
        {
            return PartialView("_IndexAsync",
                await service.GetComplexUsers()
            );
        }
    }

    public class UserService
    {
        public async Task<List<User>> GetUsers()
        {
            string uri = "http://cpayen.net/api/user.json";
            using (HttpClient httpClient = new HttpClient())
            {
                var response = await httpClient.GetStringAsync(uri);
                return JsonConvert.DeserializeObject<List<User>>(response);
            }
        }

        public async Task<List<User>> GetComplexUsers()
        {
            string uri = "http://cpayen.net/api/complex.json";
            using (HttpClient httpClient = new HttpClient())
            {
                var response = await httpClient.GetStringAsync(uri);
                return JsonConvert.DeserializeObject<List<User>>(response);
            }
        }
    }
}