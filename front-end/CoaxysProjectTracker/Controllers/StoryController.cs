using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CoaxysProjectTracker.Entities;
using System.Threading.Tasks;
using CoaxysProjectTracker.Api;

namespace CoaxysProjectTracker.Controllers
{
    public class StoryController : Controller
    {
        // GET: Story
        public async Task<ActionResult> Index()
        {
            var stories = await API.GetAsync<List<Story>>("story.json");
            return View(stories);
        }
    }
}