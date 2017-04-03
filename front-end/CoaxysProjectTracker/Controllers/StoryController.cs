using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Threading.Tasks;
using CoaxysProjectTracker.Models;
using CoaxysProjectTracker.Services;

namespace CoaxysProjectTracker.Controllers
{
    public class StoryController : Controller
    {
        // GET: Story
        public async Task<ActionResult> Index()
        {
            var stories = await Api.GetAsync<List<Story>>("story.json");
            return View(stories);
        }
    }
}