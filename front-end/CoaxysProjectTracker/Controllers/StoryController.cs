using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Threading.Tasks;
using CoaxysProjectTracker.Models;
using CoaxysProjectTracker.Services;
using CoaxysProjectTracker.Attributes;
using CoaxysProjectTracker.Repositories;

namespace CoaxysProjectTracker.Controllers
{
    [CustomAuthorize]
    public class StoryController : Controller
    {
        protected StoryRepository repository;

        public StoryController()
        {
            repository = new StoryRepository();
        }

        public async Task<ActionResult> Index()
        {
            var stories = await repository.GetStories();
            return View(stories);
        }

        public ActionResult Create()
        {
            return PartialView();
        }

        public async Task<ActionResult> Edit(int id)
        {
            var story = await repository.GetStoryByID(id);
            return View(story);
        }
    }
}